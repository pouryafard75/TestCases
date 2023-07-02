public class chain{
    void a(){
        KubernetesListBuilder builder = new KubernetesListBuilder()
                .withLivenessProbe(getLivenessProbe())
                .endContainer()
                .withVolumes(getVolumes())
                .endSpec()
                .endTemplate()
                .endSpec()
                .endReplicationControllerItem();
    }
}
