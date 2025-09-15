# 📊 Atividade PPD - Simulador de Fila de Atendimento

Bem-vindo ao repositório da **Atividade de PPD**!  
Este projeto consiste em um **simulador de filas de atendimento**, projetado para explorar conceitos de **processos estocásticos** e **análise de sistemas**.  

O objetivo é **simular diferentes cenários** e analisar o impacto de variáveis como:
- Número de caixas
- Variabilidade do tempo de serviço
- Quantidade de clientes

---

## 📝 Seção de Respostas


### 1️⃣ Simulação Padrão

**Parâmetros iniciais:**  
- µ = 5,0  
- σ = 0,5  
- N = 100 clientes  
- 1000 rodadas  

<img width="640" height="275" alt="image" src="https://github.com/user-attachments/assets/66ffcb61-5324-4c1b-8eb2-a66bc87f6062" />


---

### 2️⃣ Variação do Número de Caixas

Analise e compare os resultados ao variar o número de caixas de **1 para 2 e 3**.  
Discuta como a adição de mais caixas afeta o tempo médio de atendimento.  

**Resultados:**  

1)

<img width="640" height="275" alt="image" src="https://github.com/user-attachments/assets/d99f28cc-3118-4c86-ac74-f86cb1635d57" />

2)
<img width="629" height="273" alt="image" src="https://github.com/user-attachments/assets/dfa3889f-e573-4cad-b7fb-68fcf1fa9cc3" />

3)
<img width="617" height="272" alt="image" src="https://github.com/user-attachments/assets/3cbbdbca-cdec-4337-ab1a-058d31e9bd4c" />

---

### 3️⃣ Impacto da Variabilidade (σ)

Descreva como a variação do **desvio-padrão (σ)** impacta os resultados médios da simulação.  

**Análise:**  
<img width="657" height="178" alt="image" src="https://github.com/user-attachments/assets/55860771-4df9-423f-97f0-6de9d1aa0f66" />

A curva norma tem seu pico na média. O desvio padrão apenas demostra a dispersão dos dados,quando maior o dp mais larga a curva,quanto menor mais estreito a curva. Por meio do teste, foi notório que mesmo mudando o dp os resultados médios da simulação não alteravam muito. Mas, ao aumentar muito o dp os valores médios mudaram drasticamente, isso porque a chance de ter dados mais distantes da media aumentou.


---

### 4️⃣ Caráter Estocástico do Simulador

Explique em um parágrafo por que este simulador é considerado **estocástico** e como essa característica o torna uma representação realista de situações do mundo real.  

**Explicação:**  
- Um modelo estocástico é regido por variáveis aleatórias,então, não tem como prever uma saída mas sim chegar a uma probablidade de um resultado. Além, o mundo real é conduzido por eventos aleatórios igual o exemplar estocástico. Assim, o simulador ultiliza dados aleatórios ,igual o modelo, e gera resultados que mais se aproximam da realidade.
---

## ⚙️ Como Usar o Simulador

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
2. Execute o Main.java
   -altere os valores da simulação na Main.

