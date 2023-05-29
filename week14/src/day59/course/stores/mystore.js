import { defineStore } from 'pinia';

export const useMyStore = defineStore({
    id: 'myStore',
    state: () => ({
        count: 0,
        name: 'Danny',
        age: 25,
    }),
    actions: {
        increment() {
            this.count++;
        },
        patchNameAndAge(newName, newAge) {
            this.$patch({
                // $patch 메서드는 일부 상태만 업데이트할 때 유용
                name: newName,
                age: newAge,
            });
        },
    },
});
