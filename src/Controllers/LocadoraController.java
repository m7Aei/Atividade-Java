package Controllers;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Database.ConnectionFactory;
import Models.Locadora;

public class LocadoraController {
    public void store (Locadora locarCarro) {}

    public List<Locadora> index () {
        List<Locadora> listarCarros = new ArrayList<>();

        return listarCarros;
    }

    public List<Locadora> show () {
        List<Locadora> listarCarro = new ArrayList<>();

        return listarCarro;
    }

    public void update (Locadora updateCarro) {}

    public void delete (Locadora deletarCarro) {}
}
