package com.daw.segurhogar.entities;

public class Constants {
	
	public enum Results {
		OK(0L, "La operacion se ha realizado correctamente."),
		ERROR(1L, "Se ha producido un error al realizar la operacion.");

		private Long valor;
		private String descripcion;

		Results(Long valor, String descripcion) {
			this.valor = valor;
			this.descripcion = descripcion;
		}

		public Long getValor() {
			return valor;
		}

		public void setValor(Long valor) {
			this.valor = valor;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
	} 

}
