package br.edu.ifms.service;

public class NegocioException extends Exception {
		private static final long serialVersionUID = 1L;
		public NegocioException(String messagem) {
			super(messagem);
		}
}
