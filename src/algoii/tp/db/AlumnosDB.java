package algoii.tp.db;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

import anotaciones.FForm;
import anotaciones.HHashMap;
import anotaciones.Siguiente;

@Siguiente(nombre="Editar",next="algoii.tp.db.Alumno",label="Editar")
@FForm(title="Listado")
public class AlumnosDB
{
	private static Hashtable<Integer,Alumno> alumnos;
	private static int idAlumno;
	static
	{
		alumnos = new Hashtable<>();
		alumnos.put(1,new Alumno(1,"Juan",10));
		alumnos.put(2,new Alumno(2,"Pablo",8));
		alumnos.put(3,new Alumno(3,"Pedro",5));
		idAlumno=alumnos.size()+1;
	}
	
	public static Alumno buscarAlumno(int matricula)
	{
		return alumnos.get(matricula);
	}
	
	public static int addAlumno(String nombre,int nota)
	{
		Alumno a = new Alumno(idAlumno,nombre,nota);
		alumnos.put(idAlumno,a);
		return idAlumno++;
	}
	
	public static void updateAlumno(int id,String nombre,int nota)
	{
		Alumno a = buscarAlumno(id);
		a.setNombre(nombre);
		a.setNota(nota);
	}
	
	
	public static void crearAlumno(int matricula, String nombre, int nota)
	{
		Alumno a = new Alumno(matricula, nombre, nota);
		alumnos.put(matricula,a);
	}
	
	public static void modificarAlumno(int matricula, String nombre, int nota)
	{
		Alumno a = alumnos.get(matricula);
		a.setNombre(nombre);
		a.setNota(nota);
	}
	
	public static void eliminarAlumno(int matricula)
	{
		alumnos.remove(matricula);
	}

	public static List<Alumno> buscarTodos()
	{
		ArrayList<Alumno> lista = new ArrayList<>();
		for(Enumeration<Alumno> e=alumnos.elements(); e.hasMoreElements();)
		{
			lista.add(e.nextElement());
		}
		
		return lista;
	}
}
