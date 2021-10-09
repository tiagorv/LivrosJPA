package aplicacao;

import modelo.Livro;
import modelo.Tipo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class LivrosApp {
    public static void main(String[] args) {
        //Cria uma fabricidade de entidades, utilizando o persistenceUnid, configurado em persistence.xml
        EntityManagerFactory fabricaGerenciadorEntidades =
                Persistence.createEntityManagerFactory("minhaConexao");
        //Cria um entityManager, que vai persistir os objetos marcados como @entity
        EntityManager gerenciadorEntidade = fabricaGerenciadorEntidades.createEntityManager();

        /*Query minhaQuery = gerenciadorEntidade.createQuery("select l from Livro l");
        List<Livro> meusLivros = minhaQuery.getResultList();
        meusLivros.forEach(livro -> System.out.println(livro));*/

        /*Query minhaQuery = gerenciadorEntidade.createQuery("select JJJ.titulo from Livro JJJ");
        List<String> meusTitulos = minhaQuery.getResultList();
        meusTitulos.forEach(titulo -> System.out.println(titulo));*/

        /*Query minhaQuery = gerenciadorEntidade.createQuery("select l.anoPublicacao from Livro l");
        List<Integer> anosPublicacao = minhaQuery.getResultList();
        anosPublicacao.forEach(anoPub -> System.out.println(anoPub));*/

        /*Query minhaQuery = gerenciadorEntidade.createQuery("select l from Livro l where l.anoPublicacao >= 1997");
        List<Livro> meusLivros = minhaQuery.getResultList();
        meusLivros.forEach(livro -> System.out.println(livro));*/

        /*Query minhaQuery = gerenciadorEntidade.createQuery("select XX from Livro XX where XX.tipo.id = 1");
        List<Livro> meusLivros = minhaQuery.getResultList();
        meusLivros.forEach(livroQualquer -> System.out.println(livroQualquer));*/

     /*   Query minhaQuery = gerenciadorEntidade.createQuery("select AA from Livro AA where AA.tipo.id = :idTipo " +
                " and AA.anoPublicacao < :ano ");
        minhaQuery.setParameter("idTipo", 2);
        minhaQuery.setParameter("ano", 2000);
        List<Livro> meusLivros = minhaQuery.getResultList();
        meusLivros.forEach(livroTeste -> System.out.println(livroTeste));*/

        Query minhaQuery = gerenciadorEntidade.createQuery("select l from Livro l");
        minhaQuery.setFirstResult(2);
        minhaQuery.setMaxResults(2);
        List<Livro> meusLivros = minhaQuery.getResultList();
        meusLivros.forEach(livro -> System.out.println(livro));



        gerenciadorEntidade.close();
        fabricaGerenciadorEntidades.close();
    }
}
