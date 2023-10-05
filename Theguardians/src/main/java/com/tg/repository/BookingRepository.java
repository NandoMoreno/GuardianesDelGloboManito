package com.tg.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository; //Anotaciones de arquitectura

import com.tg.domain.Booking;

//Hibernate encargado de conectarse a la base de datos
// Jpa encarga de operar la logica en la base de datos (Metodos: insertar, eliminar etc..)

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
