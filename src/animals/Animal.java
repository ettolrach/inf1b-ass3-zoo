package animals;

import areas.AreaType;
import java.util.ArrayList;
import java.util.Collections;

/**
 * You can modify the contents of this class, but you cannot:
 * - change the name, parameters or return types of provided methods
 * - change it to an interface or concrete class
 * - remove it entirely
 */
public abstract class Animal
{
	protected String nick;
	protected AreaType areaType;
	protected AnimalSpecies species;
	protected ArrayList<AnimalSpecies> incompatibles;

	public Animal(String nickname) {
		this.nick = nickname;
		this.incompatibles = new ArrayList<>();
	}

	public AreaType getHabitat() {
		return this.areaType;
	}
	/**
	 * @return Returns this animal's given name.
	 */
	public String getNickname() {
		return nick;
	}
	public AnimalSpecies getSpecies() {
		return this.species;
	}
	public ArrayList<AnimalSpecies> getIncompatibles() {
		return incompatibles;
	}

	/**
	 * Check whether two animals can live together.
	 * @param animal The animal for which to check compatibility with this animal.
	 * @return Returns true for compatible animals and false otherwise.
	 */
	public boolean isCompatibleWith(Animal animal) {
		return !this.incompatibles.contains(animal.getSpecies());
	}
}
