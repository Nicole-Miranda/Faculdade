package ex02.factory;

import ex02.Aluno;
import util.ObjectFieldBuilder;

public class AlunoFactory {

    public static Aluno getInstance(
          Object ra,
          Object nome,
          Object ativo,
          Object qtdMesesInadimplente,
          Object notas
    ) throws ReflectiveOperationException {
        return new ObjectFieldBuilder<>(Aluno.class)
              .with("ra", ra)
              .with("nome", nome)
              .with("ativo", ativo)
              .with("qtdMesesInadimplente", qtdMesesInadimplente)
              .with("notas", notas)
              .build();
    }
}
