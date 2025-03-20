<!-- FolderItem.vue -->
<template>
  <div class="folder-item" @contextmenu.prevent="onRightClick($event)">
    <div class="folder-header" @click="toggleExpand">
      <span v-if="isFolder">{{ item.expanded ? '▼' : '▶' }}</span>
      <span>{{ item.name }}</span>
    </div>
    <div v-if="isFolder && item.expanded" class="children">
      <FolderItem
        v-for="child in item.children"
        :key="child.id"
        :item="child"
        @refresh="emitRefresh"
      />
    </div>

    <!-- Exemple d'un menu contextuel pour supprimer -->
    <div v-if="showContextMenu" class="context-menu" :style="{ top: contextMenuPosition.y + 'px', left: contextMenuPosition.x + 'px' }">
      <ul>
        <li @click="deleteItem">Supprimer</li>
        <!-- Tu peux ajouter d'autres actions ici -->
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  name: "FolderItem",
  props: {
    item: {
      type: Object,
      required: true
    }
  },
  data() {
    return {
      showContextMenu: false,
      contextMenuPosition: { x: 0, y: 0 }
    }
  },
  computed: {
    isFolder() {
      return this.item.type === 'folder'
    }
  },
  methods: {
    toggleExpand() {
      if (this.isFolder) {
        this.item.expanded = !this.item.expanded
      }
    },
    onRightClick(event) {
      this.showContextMenu = true
      this.contextMenuPosition = { x: event.clientX, y: event.clientY }
    },
    deleteItem() {
      this.showContextMenu = false
      // Appel à l'API pour supprimer l'item
      this.$emit('refresh', { action: 'delete', id: this.item.id })
      // Tu peux intégrer ici axios.delete(...) et ensuite rafraîchir l'arbre
    },
    emitRefresh() {
      this.$emit('refresh')
    }
  }
}
</script>

<style scoped>
.folder-item {
  margin-left: 1rem;
  position: relative;
}
.folder-header {
  cursor: pointer;
  user-select: none;
}
.context-menu {
  position: fixed;
  background: #fff;
  border: 1px solid #ccc;
  z-index: 9999;
}
.context-menu ul {
  list-style: none;
  margin: 0;
  padding: 0;
}
.context-menu li {
  padding: 4px 8px;
  cursor: pointer;
}
.context-menu li:hover {
  background-color: #eee;
}
</style>
