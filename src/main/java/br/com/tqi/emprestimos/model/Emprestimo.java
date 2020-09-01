package br.com.tqi.emprestimos.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "emprestimo")
public class Emprestimo {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_cliente")
    @ManyToOne
    private Cliente cliente;

    @JoinColumn (name = "id_solicitacao_emprestimo")
    @OneToOne
    private SolicitacaoEmprestimo solicitacaoEmprestimo;

    @Column(name = "valor_aprovado")
    private BigDecimal valorAprovado;


    @Column(name = "data_aprovacao")
    private Date dataAprovacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public SolicitacaoEmprestimo getSolicitacaoEmprestimo() {
        return solicitacaoEmprestimo;
    }

    public void setSolicitacaoEmprestimo(SolicitacaoEmprestimo solicitacaoEmprestimo) {
        this.solicitacaoEmprestimo = solicitacaoEmprestimo;
    }



    public BigDecimal getValorAprovado() {
        return valorAprovado;
    }

    public void setValorAprovado(BigDecimal valorAprovado) {
        this.valorAprovado = valorAprovado;
    }

    public Date getDataAprovacao() {
        return dataAprovacao;
    }

    public void setDataAprovacao(Date dataAprovacao) {
        this.dataAprovacao = dataAprovacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emprestimo that = (Emprestimo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
