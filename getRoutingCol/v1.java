public class DocIndexMetaData {
private ColumnIdent getRoutingCol() {
    if (defaultMappingMetaData != null) {
        Map<String, Object> metaMap = getNested(defaultMappingMap, "_meta");
        if (metaMap != null) {
            String routingPath = (String) metaMap.get("routing");
            if (routingPath != null) {
                return ColumnIdent.fromPath(routingPath);
            }
        }
    }
    if (primaryKey.size() == 1) {
        return primaryKey.get(0);
    }
   return ID_IDENT;
}
public DocIndexMetaData build() {
   partitionedBy = getPartitionedBy();
   columnPolicy = getColumnPolicy();
   createColumnDefinitions();
   indices = createIndexDefinitions();
   columns = ImmutableList.copyOf(columnsBuilder.build());
   partitionedByColumns = partitionedByColumnsBuilder.build();
   for (Tuple<ColumnIdent, ReferenceInfo> sysColumn : DocSysColumns.forTable(ident)) {
       referencesBuilder.put(sysColumn.v1(), sysColumn.v2());
   }
   references = referencesBuilder.build();
   primaryKey = getPrimaryKey();
   routingCol = getRoutingCol();
   return this;
}
}