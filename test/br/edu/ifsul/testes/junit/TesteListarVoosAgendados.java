/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.VooAgendado;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class TesteListarVoosAgendados {
    
   EntityManager em;
    
    public TesteListarVoosAgendados() {
    }
    
    @Before
    public void setUp() {
        em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
    }
    
    @Test
    public void teste(){
        List<VooAgendado> voosAgendados = em.createQuery("from VooAgendado").getResultList();
        for(VooAgendado va: voosAgendados){
            System.out.println(va);
        }
    }
}
