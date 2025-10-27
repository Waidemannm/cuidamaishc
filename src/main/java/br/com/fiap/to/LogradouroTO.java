package br.com.fiap.to;

import jakarta.validation.constraints.*;

public class LogradouroTO {
    //atributos
    private Long idLogradouro;
    @NotBlank(message = "O nome de logradouro não deve ser vazio.")
    private String nomeLogradouro;
    @NotNull(message = "O número não deve ser vazio.")
    @PositiveOrZero(message = "O número deve ser positivo.")
    private int numero;
    @NotNull(message = "O CEP náo deve ser vazio.")
    @Min(value = 10000000, message = "O CEP deve ter 8 dígitos.")
    @Max(value = 99999999, message = "O CEP deve ter 8 dígitos.")
    private int cep;
    @NotBlank(message = "O nome do Bairro não deve ser vazio.")
    private String bairro;
    @NotBlank(message = "O nome da Cidade não deve ser vazio.")
    private String cidade;
    @NotBlank(message = "A sigla do estado não deve ser vazio.")
    //Em LogradouroBO colocar uma regra de negocio especifica que verifica se a sgEstado está em um ArrayList que contem todas as siglas de estados.
    private String sgEstado;
    //construtores
    public LogradouroTO() {
    }

    public LogradouroTO(int numero, String nomeLogradouro, Long idLogradouro, int cep, String bairro, String cidade, String sgEstado) {
        this.numero = numero;
        this.nomeLogradouro = nomeLogradouro;
        this.idLogradouro = idLogradouro;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.sgEstado = sgEstado;
    }
    //métodos getters/setters
    public Long getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Long idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getNomeLogradouro() {
        return nomeLogradouro;
    }

    public void setNomeLogradouro(String nomeLogradouro) {
        this.nomeLogradouro = nomeLogradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getSgEstado() {
        return sgEstado;
    }

    public void setSgEstado(String sgEstado) {
        this.sgEstado = sgEstado;
    }

}
