public class chain{
    void a(){
        KubernetesListBuilder builder = new KubernetesListBuilder()
                .withLivenessProbe(getLivenessProbe())
                .withReadinessProbe(getReadinessProbe())
                .endContainer()
                .withVolumes(getVolumes())
                .endSpec()
                .endTemplate()
                .endSpec()
                .endReplicationControllerItem();
    }
}
