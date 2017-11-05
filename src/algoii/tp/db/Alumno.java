package algoii.tp.db;

import anotaciones.FForm;
import anotaciones.IInput;

@FForm(title="Alumno")
public class Alumno
{
	@IInput(label="legajo",editable=false)
	private int legajo;
	@IInput(label="Nombre")
	private String nombre;
	@IInput(label="Nota")
	private int nota;
	
	public Alumno(int le,String no, int not)
	{
		legajo=le;
		nombre=no;
		nota=not;
	}
	
	public int getLegajo()
	{
		return legajo;
	}
	public void setLegajo(int legajo)
	{
		this.legajo=legajo;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre=nombre;
	}
	public int getNota()
	{
		return nota;
	}
	public void setNota(int nota)
	{
		this.nota=nota;
	}
}
