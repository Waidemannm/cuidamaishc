package br.com.fiap.to;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class PacienteTO extends PessoaTO{
    //Atributos
    private Long idPaciente;
    @Positive(message = "O ID deve ser um número positivo.")
    private Long idLogradouro;
    @NotBlank
    @Length(min = 8, max = 80, message = "A senha deve ter entre 8 e 80 caracteres.")
    private String senha;
    //construtores
    public PacienteTO(){}

    public PacienteTO(String nome, LocalDate dataNascimento, String cpf, Long idPaciente, Long idLogradouro, String senha) {
        super(nome, dataNascimento, cpf);
        this.idPaciente = idPaciente;
        this.idLogradouro = idLogradouro;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
