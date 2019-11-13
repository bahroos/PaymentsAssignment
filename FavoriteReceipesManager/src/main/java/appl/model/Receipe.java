package appl.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
@Table(name = "receipes")
@ApiModel(description = "All details about the Receipes.")
public class Receipe {

	@ApiModelProperty(notes = "The database generated receipe ID")
	private @Id @GeneratedValue Long id;

	@ApiModelProperty(notes = "The title of the receipe")
	private String title;

	@ApiModelProperty(notes = "The dateTime of the receipe")
	private String  dateTime;

	@ApiModelProperty(notes = "A boolean for vegetarians, yes implying that the user is a vegetarian.")
	private boolean vegetarian;

	@ApiModelProperty(notes = "The ingredients of the receipe (comma seperated for now)")
	private String ingredients;

	@ApiModelProperty(notes = "The cooking instructions for the receipe.")
	private String cookingInstructions;

	@ApiModelProperty(notes = "The optimal number of people for whom the dish is fit.")
	private int optimalNoOfPeople;

	//Not used
	public void setTitle(String title) {
		this.title = title;
	}

	//Not used
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	@Column(name = "vegetarian", nullable = false)
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	@Column(name = "ingredients", nullable = false)
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	@Column(name = "cookingInstructions", nullable = false)
	public void setCookingInstructions(String cookingInstructions) {
		this.cookingInstructions = cookingInstructions;
	}

	@Column(name = "optimalNoOfPeople", nullable = false)
	public void setOptimalNoOfPeople(int optimalNoOfPeople) {
		this.optimalNoOfPeople = optimalNoOfPeople;
	}

	public Receipe() {
	}

	Receipe(String title, String cookingInstructions, int optimalNoOfPeople, boolean vegetarian, String ingredients) {
		this.title = title;
		this.vegetarian = vegetarian;
		this.optimalNoOfPeople = optimalNoOfPeople;
		SimpleDateFormat formatter= new SimpleDateFormat("dd‐mm‐yyyy hh:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		System.out.println("date: [" + date + "]" );
		dateTime  = formatter.format(date);
		this.cookingInstructions = cookingInstructions;
        this.ingredients = ingredients;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Receipe)) return false;
		Receipe receipe = (Receipe) o;
		return isVegetarian() == receipe.isVegetarian() &&
				getOptimalNoOfPeople() == receipe.getOptimalNoOfPeople() &&
				Objects.equals(getId(), receipe.getId()) &&
				Objects.equals(getTitle(), receipe.getTitle()) &&
				Objects.equals(getDateTime(), receipe.getDateTime()) &&
				Objects.equals(getIngredients(), receipe.getIngredients()) &&
				Objects.equals(getCookingInstructions(), receipe.getCookingInstructions());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getTitle(), getDateTime(), isVegetarian(), getIngredients(), getCookingInstructions(), getOptimalNoOfPeople());
	}

	public String getTitle() {
		return title;
	}

	public int getOptimalNoOfPeople() {
		return optimalNoOfPeople;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public String getDateTime() {
		return dateTime;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public String getIngredients() {
		return ingredients;
	}

	public String getCookingInstructions() {
		return cookingInstructions;
	}

	@Override
	public String toString() {
		return "Receipe{" +
				"id=" + id +
				", title='" + title + '\'' +
				", dateTime='" + dateTime + '\'' +
				", vegetarian=" + vegetarian +
				", ingredients='" + ingredients + '\'' +
				", cookingInstructions='" + cookingInstructions + '\'' +
				", optimalNoOfPeople=" + optimalNoOfPeople +
				'}';
	}
}
