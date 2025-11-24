public class Administrador extends Usuario {

    public Administrador(String id, String nome) {
        super(id, nome);
    }

    @Override
    public String getTipoUsuario() {
        return "Administrador";
    }

    @Override
    public boolean podeAdicionarVeiculo() {
        return true;
    }
}
