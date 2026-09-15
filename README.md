# Por que essas escolhas de design?

## Sealed class para as rotas
- Guarda o nome da rota (`route: String`) e ainda dá um tipo próprio pra cada tela — algo que um enum comum não faz bem.
- O Kotlin conhece todos os subtipos, então se eu esquecer de tratar uma tela em algum `when` futuro, o compilador acusa.
- Evita string solta tipo `"home_screen"` espalhada pelo código, onde um erro de digitação só apareceria quando o app quebrasse.

## Argumento de rota (Home → AddWord)
- É o jeito natural do Navigation Compose de mandar dado de uma tela pra outra.
- Mantém as telas independentes: a AddWordScreen não precisa saber que existe uma HomeScreen, só recebe uma String de algum lugar.
- Uma variável global até resolveria, mas criaria estado compartilhado sem necessidade nenhuma.

## SavedStateHandle (AddWord → Home)
- Aqui o dado precisa viajar no sentido contrário, sem abrir uma tela nova de novo com `navigate()`.
- É exatamente pra isso que o SavedStateHandle existe: guarda o valor ligado à entrada da tela que vai recebê-lo.
- Sobrevive ao `popBackStack()` e evita que as duas telas precisem se conhecer.

## Resumo
Os três resolvem o mesmo problema por ângulos diferentes: levar dado pra frente, trazer de volta, e garantir que as rotas usadas nesses dois processos estejam certas — sem acoplar as telas e sem estado global.
