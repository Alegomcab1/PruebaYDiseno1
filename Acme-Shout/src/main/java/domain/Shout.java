
package domain;

import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

// Se crea la entidad, el entiti hace que sea persistente
@Entity
public class Shout extends DomainEntity {

	//Se declaran las variables que queremos mostrar
	private String	username;
	private String	link;
	private String	text;


	@NotBlank
	public String getUsername() {
		return this.username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}

	@NotBlank
	@URL
	public String getLink() {
		return this.link;
	}
	public void setLink(final String link) {
		this.link = link;
	}

	@NotBlank
	public String getText() {
		return this.text;
	}
	public void setText(final String text) {
		this.text = text;
	}

}
