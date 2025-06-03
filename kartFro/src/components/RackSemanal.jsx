import React, { useState } from "react";
import "./RackSemanal.css";
import Navbar from "./Navbar";

const RackSemanal = () => {
  const [selectedDate, setSelectedDate] = useState(new Date());

  // Función para obtener el lunes de la semana actual
  const getLunesSemana = (date) => {
    const tempDate = new Date(date);
    const day = tempDate.getDay() || 7; // Domingo será 7 en lugar de 0
    if (day !== 1) {
      tempDate.setHours(-24 * (day - 1)); // Retroceder al lunes
    }
    return tempDate;
  };

  // Función para formatear fecha como YYYY-MM-DD
  const formatDate = (date) => {
    return date.toISOString().split('T')[0];
  };

  // Obtener el rango de fechas de la semana
  const lunesSemana = getLunesSemana(selectedDate);
  const domingoSemana = new Date(lunesSemana);
  domingoSemana.setDate(domingoSemana.getDate() + 6);

  // Función para cambiar de semana
  const cambiarSemana = (direccion) => {
    const nuevaFecha = new Date(selectedDate);
    nuevaFecha.setDate(nuevaFecha.getDate() + (direccion * 7));
    setSelectedDate(nuevaFecha);
  };

  // Horarios de atención (bloques de 1 hora)
  const horarios = [
    "10:00", "11:00", "12:00", "13:00", "14:00",
    "15:00", "16:00", "17:00", "18:00", "19:00"
  ];

  // Días de la semana con fechas
  const diasSemana = Array.from({ length: 7 }, (_, i) => {
    const fecha = new Date(lunesSemana);
    fecha.setDate(fecha.getDate() + i);
    return {
      nombre: ["Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"][i],
      fecha: fecha
    };
  });

  return (
    <div className="rack-container">
      <Navbar />
      <div className="rack-content">
        <h1>Rack Semanal de Reservas</h1>
        
        {/* Selector de semana */}
        <div className="semana-selector">
          <button 
            onClick={() => cambiarSemana(-1)}
            className="btn-semana"
          >
            ← Semana anterior
          </button>
          
          <div className="semana-info">
            <input 
              type="date" 
              value={formatDate(selectedDate)}
              onChange={(e) => setSelectedDate(new Date(e.target.value))}
              className="fecha-selector"
            />
            <span className="rango-semana">
              {formatDate(lunesSemana)} - {formatDate(domingoSemana)}
            </span>
          </div>

          <button 
            onClick={() => cambiarSemana(1)}
            className="btn-semana"
          >
            Semana siguiente →
          </button>
        </div>

        <div className="rack-description">
          <p>Horario de atención: 10:00 - 20:00 hrs</p>
          <div className="rack-legend">
            <span className="disponible">Disponible</span>
            <span className="reservado">Reservado</span>
          </div>
        </div>
        
        <div className="rack-table">
          <div className="rack-header">
            <div className="hora-header">Hora</div>
            {diasSemana.map(dia => (
              <div key={dia.nombre} className="dia-header">
                <div className="dia-nombre">{dia.nombre}</div>
                <div className="dia-fecha">{formatDate(dia.fecha)}</div>
              </div>
            ))}
          </div>
          
          <div className="rack-body">
            {horarios.map(hora => (
              <div key={hora} className="rack-row">
                <div className="hora-cell">{hora}</div>
                {diasSemana.map(dia => (
                  <div 
                    key={`${dia.nombre}-${hora}`} 
                    className="rack-cell disponible"
                    title={`${dia.nombre} ${formatDate(dia.fecha)} - ${hora}`}
                  />
                ))}
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
};

export default RackSemanal;