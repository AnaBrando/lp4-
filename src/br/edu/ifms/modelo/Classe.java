package br.edu.ifms.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Classe {
		private Long codigo;
		private String descricao;
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public long getCodigo() {
			return codigo;
		}

		public String getNome() {
			return descricao;
		}

		public void setNome(String descricao) {
			this.descricao = descricao;
		}

		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		@Override
		public int hashCode() {
				final int prime=31;
				int result = 1;
				result = prime * result + ((codigo == null)?0 : codigo.hashCode());
				return result;
		}
		@Override
		public boolean equals(Object obj) {
			if(this == obj)
				return true;
			if(obj == null)
				return false;
			if(getClass() != obj.getClass())
				return false;
			Classe other =(Classe) obj;
			if(codigo == null) {
				if(other.codigo != null)
					return false;
			}else if(!codigo.equals(other.codigo))
				return false;
			return true;
		
		}
		
}
