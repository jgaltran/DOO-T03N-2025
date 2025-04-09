package Alunos.Braian.Aula07;

 class Endereco{
    private String estado;
    private String cidade;
    private String bairro;
    private String nomeRua;
    private Integer numeroRua;
    private String complemento;

    public Endereco(String estado, String cidade, String bairro, String nomeRua, Integer numeroRua, String complemento){
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numeroRua = numeroRua;
        this.complemento = complemento;
      }
          public String getEstado(){
            return estado;
          }
          public String getCidade(){
            return cidade;
          }
          public String getBairro(){
            return bairro;
          }
          public String getNomeRua(){
            return nomeRua;
          }
          public Integer getNumeroRua(){
            return numeroRua;
          }
          public String getComplemento(){
            return complemento;
          }
          public void setEstado(String estado){
            this.estado = estado;
          }
          public void setCidade(String cidade){
            this.cidade = cidade;
          }
          public void setBairro(String bairro){
            this.bairro = bairro;
          }
          public void setNumeroRua(Integer numeroRua){
            this.numeroRua = numeroRua;
          }
          public void setComplemento(String complemento){
            this.complemento = complemento;
          }

          public void apresentarLogradouro() {
            System.out.println("Endereço: " + this.nomeRua + ", nº " + this.numeroRua + " - " + this.bairro + ", " + this.cidade + " - " + this.estado + ". " + this.complemento);
          }

 }
