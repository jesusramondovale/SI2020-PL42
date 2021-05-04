package giis.demo.proyectoClub.model;

import java.util.List;

import giis.demo.proyectoClub.DTO.InstalacionDisplayDTO;
import giis.demo.util.Database;

public class EditarInstalacionesModel {

	public Database db = new Database();
	
	
	public void editarAforo(double aforo, int id) {
		String sql="UPDATE instalacion SET aforo=? WHERE idInstalacion=?";
		db.executeUpdate(sql, aforo, id);
	}
	
	public List<InstalacionDisplayDTO> getAforo() {
		// TODO Auto-generated method stub
		String sql= "SELECT aforo from instalacion";
		return db.executeQueryPojo(InstalacionDisplayDTO.class, sql);
	}
}
