package sabc.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import sabc.domain.*;

@Component
public class SanctionHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Sanction>> {

    @Override
    public EntityModel<Sanction> process(EntityModel<Sanction> model) {
        return model;
    }
}
