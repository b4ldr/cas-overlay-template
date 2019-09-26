import org.apereo.cas.authentication.*
import java.util.function.*
import org.apereo.cas.services.*

class PredicateExample implements Predicate<MultifactorAuthenticationProvider> {

    def service
    def principal
    def providers
    def logger

    public PredicateExample(service, principal, providers, logger) {
        this.service = service
        this.principal = principal
        this.providers = providers
        this.logger = logger
    }

    @Override
    boolean test(final MultifactorAuthenticationProvider p) {
	logger.debug(
		'testing attribute value [{}] against provider [{}] with service [{}]',
		this.principal.attributes['preferredLanguage'], p, this.service)
	if (this.principal.attributes['preferredLanguage'].contains(p.getId())) {
		logger.info("Provider {} is available.", p.getId())
		return true
	}
	return false
    }
}
