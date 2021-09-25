package aplicacao;

import modelo.Livro;
import modelo.Tipo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LivrosApp {
    public static void main(String[] args) {
        //Cria uma fabricidade de entidades, utilizando o persistenceUnid, configurado em persistence.xml
        EntityManagerFactory fabricaGerenciadorEntidades =
                Persistence.createEntityManagerFactory("minhaConexao");
        //Cria um entityManager, que vai persistir os objetos marcados como @entity
        EntityManager gerenciadorEntidade = fabricaGerenciadorEntidades.createEntityManager();

        //Inserção de dados
        /*Tipo tipo1 = new Tipo();
        tipo1.setDescricao("Romance");

        Tipo tipo2 = new Tipo();
        tipo2.setDescricao("Historia");

        Tipo tipo3 = new Tipo();
        tipo3.setDescricao("Biografia");

        gerenciadorEntidade.getTransaction().begin();
        gerenciadorEntidade.persist(tipo1);
        gerenciadorEntidade.persist(tipo2);
        gerenciadorEntidade.persist(tipo3);
        gerenciadorEntidade.getTransaction().commit();
*/

        //Selecionar no banco de dados
        /*Tipo tipoNoBanco = gerenciadorEntidade.find(Tipo.class, 4);
        System.out.println(tipoNoBanco);*/

/*        Tipo tipoAtualizar = gerenciadorEntidade.find(Tipo.class, 1);
        tipoAtualizar.setDescricao("Romance Saltless");

        gerenciadorEntidade.getTransaction().begin();
        gerenciadorEntidade.persist(tipoAtualizar);
        gerenciadorEntidade.getTransaction().commit();*/

        /*Tipo tipoAExcluir = gerenciadorEntidade.find(Tipo.class, 3);

        gerenciadorEntidade.getTransaction().begin();
        gerenciadorEntidade.remove(tipoAExcluir);
        gerenciadorEntidade.getTransaction().commit();*/


        Tipo tipoCadastrado = gerenciadorEntidade.find(Tipo.class, 2);
        Livro livro1 = new Livro();
        livro1.setTitulo("Senhor dos Anéis");
        livro1.setAutor("J.R.R. Tolkien");
        livro1.setTipo(tipoCadastrado);

        gerenciadorEntidade.getTransaction().begin();
        gerenciadorEntidade.persist(livro1);
        gerenciadorEntidade.getTransaction().commit();

        gerenciadorEntidade.close();
        fabricaGerenciadorEntidades.close();
    }
}
