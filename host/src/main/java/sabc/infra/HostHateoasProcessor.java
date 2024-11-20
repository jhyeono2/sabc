package sabc.infra;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;
import sabc.domain.*;

@Component
public class HostHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Host>> {

    @Override
    public EntityModel<Host> process(EntityModel<Host> model) {
        return model;
    }
}
