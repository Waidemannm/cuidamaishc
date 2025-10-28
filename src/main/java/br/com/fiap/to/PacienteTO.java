package br.com.fiap.to;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class PacienteTO extends PessoaTO{
    //Atributos
    private Long idPaciente;
    @Positive(message = "O ID deve ser um número positivo.")
    private Long idLogradouro;
    //construtores
    public PacienteTO(){}

    public PacienteTO(String nome, LocalDate dataNascimento, String cpf, Long idPaciente, Long idLogradouro) {
        super(nome, dataNascimento, cpf);
        this.idPaciente = idPaciente;
        this.idLogradouro = idLogradouro;
    }
    //metodos getters/setters

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Long getIdLogradouro() {
        return idLogradouro;
    }

    public void setIdLogradouro(Long idLogradouro) {
        this.idLogradouro = idLogradouro;
    }
}
