package algoii.tp.db;

import java.util.List;

public class AlumnoDBTest
{
	public static void main(String[] args)
	{
		List<Alumno> lst = AlumnosDB.buscarTodos();
		for(Alumno a:lst)
		{
			System.out.println(a.getLegajo()+", "+a.getNombre()+", "+a.getNota());
		}
		
		System.out.println("---");
		
		Alumno x = AlumnosDB.buscarAlumno(2);
		if( x!=null )
		{
			System.out.println(x.getLegajo()+", "+x.getNombre()+", "+x.getNota());			
		}
		else
		{
			System.out.println("Alumno no encontrado");
		}
		
		System.out.println("---");
		int id = AlumnosDB.addAlumno("Jose",10);
		System.out.println("Id Asignado: "+id);
		lst = AlumnosDB.buscarTodos();
		for(Alumno a:lst)
		{
			System.out.println(a.getLegajo()+", "+a.getNombre()+", "+a.getNota());
		}
		System.out.println("---");
		Alumno p = AlumnosDB.buscarAlumno(4);
		System.out.println(p.getLegajo()+", "+p.getNombre()+", "+p.getNota());
		AlumnosDB.updateAlumno(4,"Jose Alberto",9);
		p = AlumnosDB.buscarAlumno(4);
		System.out.println(p.getLegajo()+", "+p.getNombre()+", "+p.getNota());

	}
}
