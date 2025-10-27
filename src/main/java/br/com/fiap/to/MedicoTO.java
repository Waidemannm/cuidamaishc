package br.com.fiap.to;

import jakarta.validation.constraints.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class MedicoTO extends PessoaTO{
    //Atributos
    private Long idMedico;
    @NotNull(message = "O CRM é obrigatório.")
    @Min(value = 10000, message = "O CRM deve ter pelo menos 4 dígitos.")
    @Max(value = 999999999, message = "O CRM não pode ter mais que 9 dígitos.")
    private int crm;
    @NotBlank(message = "A especialidade não deve ser vazia.")
    private String especialidade;
    //construtores
    public MedicoTO() {
    }

    public MedicoTO(String nome, LocalDate dataNascimento, String cpf, Long idMedico, int crm, String especialidade) {
        super(nome, dataNascimento, cpf);
        this.idMedico = idMedico;
        this.crm = crm;
        this.especialidade = especialidade;
    }
    //metodos getters/setters

    public Long getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Long idMedico) {
        this.idMedico = idMedico;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
}
