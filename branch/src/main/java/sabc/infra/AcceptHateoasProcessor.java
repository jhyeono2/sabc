package sabc.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import sabc.domain.*;

@Component
public class AcceptHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Accept>> {

    @Override
    public EntityModel<Accept> process(EntityModel<Accept> model) {
        return model;
    }
}
