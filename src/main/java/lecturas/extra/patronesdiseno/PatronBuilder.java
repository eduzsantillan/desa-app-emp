package lecturas.extra.patronesdiseno;

import utilitarios.Usuario;

public class PatronBuilder {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("Eduardo", null, "eduzsantillan@gmail.com", 0, "72131232");
        Usuario usuario2 = new Usuario("Michele", "Pfeifer", "michael@gmail.com", 32, "72131232");

        Usuario usuario3 = Usuario.builder()
                .nombre("Kilyan")
                .email("mbappe@realmadrid.es")
                .nroDocumento("12345678")
                .build();
        System.out.println(usuario3);
    }
}



