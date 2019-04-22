/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes.junit;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Pessoa;
import java.text.SimpleDateFormat;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marce
 */
public class TestePersistirPessoa {
    
    EntityManager em;
    
    public TestePersistirPessoa() {
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
        try {
            Pessoa p = new Pessoa();
            p.setNome("Marcelo Felipe G. Fernandes");
            p.setEmail("email@gmail.com");
            p.setTelefone("+5554999990000");
            p.setCpf("007.079.140-60");
                               
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro: " +e);
        }
    }
}
