package com.utad.mais.proyectoFinal.pattern.strategy;

import com.utad.mais.proyectoFinal.pattern.singleton.Calculadora;
import com.utad.mais.proyectoFinal.personajes.*;

public class HealingStrategy implements EnemyStrategy 
{
	/*
	 * Clase estrategia de curaci�n. 
	 * 
	 * Todos los enemigos que la implemente se les permitir� realizar las acciones descritas en la documentaci�n,
	 * ya que las estrategias difieren a la hora de las acciones que puede realizar el enemigo.
	 * 
	 * El m�todo applyStrategy se utiliza para aplicar la acci�n de forma aleatoria.
	 * Las probabilidades est�n descritas en la documentaci�n.
	 * 
	 * El resto de m�todos llaman a la clase Calculadora que es la encargada de modificar las estad�sticas de los personajes
	 * seg�n la acci�n realizada y de escribir por pantalla dicha acci�n.
	 * 
	 * Los m�todos que no permiten ser usados por la estrategia incorporan el lanzamiento de una excepci�n.
	 */
	@Override
	public void applyStrategy(Personaje personaje1, Personaje personaje2)
	{
		double i = Math.random();
		if(i>=0.45)
		{
			this.heal(personaje1);
		}
		else if(i<0.45 && i>=0.2)
		{
			this.attack(personaje1,personaje2);
		}
		else
		{
			this.defend(personaje1,personaje2);
		}
		
	}

	@Override
	public void attack(Personaje personaje1, Personaje personaje2) 
	{
		System.out.println(personaje1.getName()+" atac� a "+personaje2.getName());
		Calculadora.getInstance().calculaDa�oRecibido(personaje1, personaje2);
	}

	@Override
	public void defend(Personaje personaje1,Personaje personaje2) 
	{
		System.out.println(personaje1.getName()+" se defendi�");
		Calculadora.getInstance().calculaDefendido(personaje1, personaje2);
	}

	@Override
	public void heal(Personaje personaje1) 
	{
		System.out.println(personaje1.getName()+" se cur� as� mimsmo");
		Calculadora.getInstance().calculaCuraRecibida(personaje1);
	}

	@Override
	public void buff(Personaje personaje1) 
	{
		throw new IllegalStateException("Buff is not available");
	}

	@Override
	public void activarCaracteristica(Personaje personaje1,Personaje personaje2) 
	{
		throw new IllegalStateException("Caracter�stica is not available");
	}
}
