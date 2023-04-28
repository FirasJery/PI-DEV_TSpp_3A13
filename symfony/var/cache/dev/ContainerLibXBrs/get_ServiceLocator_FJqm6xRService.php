<?php

namespace ContainerLibXBrs;

use Symfony\Component\DependencyInjection\Argument\RewindableGenerator;
use Symfony\Component\DependencyInjection\Exception\RuntimeException;

/**
 * @internal This class has been auto-generated by the Symfony Dependency Injection Component.
 */
class get_ServiceLocator_FJqm6xRService extends App_KernelDevDebugContainer
{
    /**
     * Gets the private '.service_locator.FJqm6xR' shared service.
     *
     * @return \Symfony\Component\DependencyInjection\ServiceLocator
     */
    public static function do($container, $lazyLoad = true)
    {
        return $container->privates['.service_locator.FJqm6xR'] = new \Symfony\Component\DependencyInjection\Argument\ServiceLocator($container->getService, [
            'reclamation' => ['privates', '.errored..service_locator.FJqm6xR.App\\Entity\\Reclamation', NULL, 'Cannot autowire service ".service_locator.FJqm6xR": it references class "App\\Entity\\Reclamation" but no such service exists.'],
            'reclamationRepository' => ['privates', 'App\\Repository\\ReclamationRepository', 'getReclamationRepositoryService', true],
            'repRep' => ['privates', 'App\\Repository\\ReponseRepository', 'getReponseRepositoryService', true],
        ], [
            'reclamation' => 'App\\Entity\\Reclamation',
            'reclamationRepository' => 'App\\Repository\\ReclamationRepository',
            'repRep' => 'App\\Repository\\ReponseRepository',
        ]);
    }
}
