# PROJETO 1: ÁRVORES E BALANCEAMENTO

* Este projeto foi realizado na IDE Eclipse
* **JDK** utilizado no projeto: JDK24
---
## INSTRUÇÕES PARA RODAR O PROJETO: 
> [!IMPORTANT]
> É recomendado rodar o projeto em uma IDE própria para Java (como IntelliJ ou Eclipse).

### Como clonar o repositório para sua máquina:
Para clonar o repositório, é bem simples, para isso, utilize o comando abaixo:
```bash
git clone https://github.com/Art-26/Projeto1Gabriel.git
```
>[!TIP]
>Você deve conter o Git bash instalado em sua máquina, caso contrário, o comando não irá funcionar!

Após isso, iremos abrir o prompt de comando, para isso, clique em Windows + R, digite cmd e clique em Enter

No prompt de comando, você deverá escolher em qual diretório ou pasta será clonado o projeto, como exemplo, usamos o diretório Downloads
```bash
cd C:\Users\SEU_USUARIO\Downloads
```
Feito isso, ainda no prompt de comando, você irá colar o comando do git clone e dar um Enter.

---
## Como executar projeto no Eclipse
Abra o Eclipse IDE e clique em **File > Import... > General > Project from Folder or Archive > Next**, abrirá uma tela onde está escrito **Import Source**, mais para a direita, haverá um botão escrito **Directory**, clique nele, após isso, basta selecionar a pasta do projeto 'Projeto1Gabriel'.

Após selecionar a pasta do projeto, basta clicar em **Finish**.

O projeto irá aparecer na tela ao lado, em **Package Explorer**

Por fim, basta dar dois cliques em **Projeto1Gabriel > TrabalhosGabriel/src > principal > Main.java**

tendo selecionado o arquivo Main.java, basta clicar em **Run**, que está localizado na barra superior, ou clicar no ícone Verde de Iniciar, que está localizado abaixo da barra superior, ao lado do ícone de um inseto (tipo um besouro). (Atalho: Ctrl + F11) em alguns teclados pode ser necessário o Fn (Ctrl + Fn + F11).

---
## Como executar projeto no IntelliJ
Abra o IntelliJ e clique em **Open**, após isso, basta selecionar a pasta 'Projeto1Gabriel', e clicar em **Select Folder**.

Após isso, basta clicar em **TrabalhosGabriel > principal > Main.java** e executar o arquivo clicando no botão verde de Play ao lado de **current file** na barra superior. (Atalho para executar: (Shift + F10), em alguns teclados pode ser necessário o Fn (Shift + Fn + F10).

---
## Como executar projeto no Visual Studio Code
Abra o Visual Studio Code e clique em **Abrir pasta** (Atalho: Ctrl + Shift + E), após isso, basta selecionar a pasta 'Projeto1Gabriel' acessar **TrabalhosGabriel > principal > Main.java**, após acessar o arquivo, basta executar o projeto clicando no ícone de Play, localizado na barra superior (A mesma barra onde exibe os arquivos abertos no Visual Studio Code), no canto superior direito.

> [!IMPORTANT]
> Para o projeto funcionar corretamente no Visual Studio Code, será necessário a extensão **Extension Pack for Java** e a extensão **Portuguese (Brazil) Language Pack for Visual Studio Code** para ter acesso ao Visual Studio Code completamente em PT-BR.

---
## Como executar o projeto por prompt de comando
Primeiramente, acesse o Prompt de Comando, clicando em Tecla Windows + R, digite cmd e clique em Enter, após isso, teremos que fazer o seguinte passo a passo, usaremos de exemplo o repositório clonado no diretório Downloads:

1. Copie o comando abaixo:
```bash
cd C:\Users\SEU_USUARIO\Downloads\Projeto1Gabriel\TrabalhosGabriel
```
Insira o comando acima e clique em Enter.

Feito isso, você estará dentro da pasta do projeto.

2. Agora, você deverá copiar o seguinte comando:
```bash
javac -d bin src/modelos/*.java src/algoritmos/*.java src/principal/*.java
```
insira o comando e digite Enter.

Por fim, basta copiar o seguinte comando:
```bash
java -cp bin principal.Main
```
Insira no prompt de comando e pronto, o código estará rodando.

>[!TIP]
>Após terminar esse passo a passo, caso queira executar o projeto novamente, basta ignorar a etapa 2, pois a pasta bin já vai ter sido criada corretamente na primeira execução.

---
