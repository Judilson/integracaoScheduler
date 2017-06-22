/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.giex.schedule;

/**
 *
 * @author Judilson
 */
import br.com.giex.conexao.ConectaBanco;
import br.com.giex.scheduler.Servico;
import br.com.giex.scheduler.ServicoService;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.ejb.Stateless;

@Stateless
public class Job {
    public void processos() {
        try {
            Connection conn = new ConectaBanco().conecta();
            ResultSet query = conn.createStatement().executeQuery("select id_credor "
                    + " from tb_credor where status_credor_n = 1 and fn_processo_credor(id_credor) = 'S'");
            while (query.next()) {
                Servico serv = new ServicoService().getServicoPort();
                serv.chamaCredor(query.getInt("id_credor"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}