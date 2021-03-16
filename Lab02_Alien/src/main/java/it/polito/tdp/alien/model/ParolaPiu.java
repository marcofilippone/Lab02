package it.polito.tdp.alien.model;

public class ParolaPiu {
	
	private String ali;
	private String ita;
	
	public ParolaPiu(String ali, String ita) {
		super();
		this.ali = ali;
		this.ita = ita;
	}

	public String getAli() {
		return ali;
	}

	public void setAli(String ali) {
		this.ali = ali;
	}

	public String getIta() {
		return ita;
	}

	public void setIta(String ita) {
		this.ita = ita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ali == null) ? 0 : ali.hashCode());
		result = prime * result + ((ita == null) ? 0 : ita.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParolaPiu other = (ParolaPiu) obj;
		if (ali == null) {
			if (other.ali != null)
				return false;
		} else if (!ali.equals(other.ali))
			return false;
		if (ita == null) {
			if (other.ita != null)
				return false;
		} else if (!ita.equals(other.ita))
			return false;
		return true;
	}
	
	

}
