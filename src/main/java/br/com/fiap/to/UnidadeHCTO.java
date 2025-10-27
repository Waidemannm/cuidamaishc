package br.com.fiap.to;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class UnidadeHCTO {
    //Atributos
    private Long idUnidade;
    @NotNull(message = "O ID não deve ser vazio.")
    @Positive(message = "O ID deve ser número positivo.")
    private Long idLogradouro;
    @NotBlank(message = "O nome não pode ser vazio.")
    private String nomeUnidade;
    @PastOrPresent(message = "A data deve ser no passado, ou hoje.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataFundacao;
    //construtores
    public UnidadeHCTO() {
    }

    public UnidadeHCTO(Long idUnidade, Long idLogradouro, String nomeUnidade, LocalDate dataFundacao) {
        this.idUnidade = idUnidade;
        this.idLogradouro = idLogradouro;
        this.nomeUnidade = nomeUnidade;
    }

    //metodos getters/setters
    public Long getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(Long idUnidade) {
        this.idUnidade = idUnidade;
    }

    public Long getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Long idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }
}
