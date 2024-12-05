create table pagamento
(
    id_pagamento        int            not null
        primary key,
    datahora            datetime(6)    not null,
    valor               decimal(38, 2) not null,
    id_metodo_pagamento int            null,
    constraint id_metodo_pagamento_fk
        foreign key (id_metodo_pagamento) references metodo_pagamento (id_metodo_pagamento)
);

