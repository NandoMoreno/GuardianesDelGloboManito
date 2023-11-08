package com.tg.util;

public interface CONSTANTES {
	
	/**
	 * 
	 * @author Andres C	
	 * {@summary Todo lo relacionado con la edad de las pesonas}@ 
	 *
	 */
	public class EDADES {
		public static final String NIÑO = "NIÑO(A)";
		public static final String ADOSLECENTE = "ADOSLECENTE";
		public static final String ADULTO_JOVEN = "ADULTO(A) JOVEN";
		public static final String ADULTO = "ADULTO(A)";
		public static final String ANCIANO = "ANCIANO(A)";
		
		public static final String devolverEdad(Long edad) {
			if (edad < 10) {
				return NIÑO;
			}if (edad > 10 && edad < 18){
				return ADOSLECENTE;
			}if (edad > 18 && edad < 28){
				return ADULTO_JOVEN;
			}if (edad > 28 && edad < 60){
				return ADULTO;
			}if (edad > 60 ){
				return ANCIANO;
			}
			
			return "Hay problemas con esta edad";
		}
	}
	
	/**
	 * @author Andres C
	 * {@summary Todo lo relacionado con los fondos}
	 */
	public class FONDOS {
		public static final String LEGAL = "LEGAL";
		public static final String ILEGAL = "ILEGAL";
		public static final String CONFIABLE = "CONFIABLE";
		public static final String NO_CONFIABLE = "NO_CONFIABLE";
		
		public static final String confiabialidadDeLosFondos(String origen) {
			switch (origen) {
			case LEGAL: {
				return CONFIABLE;
			}
			case ILEGAL:
				return NO_CONFIABLE;
			default:
				throw new IllegalArgumentException("Este valor no existe: " + origen);
			}
		}
	}
}
