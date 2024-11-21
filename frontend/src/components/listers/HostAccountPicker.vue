<template>
    <div>
        <v-list two-line v-if="list.length > 0">
            <v-list-item-group 
                    v-model="selected" 
                    color="primary"
                    @change="select"
            >
                <v-list-item v-for="(item, idx) in list" :key="idx">
                    <template v-slot:default="{ active }">
                        <v-list-item-avatar color="primary-darker-1">
                        </v-list-item-avatar>
                        
                        <v-list-item-content>
                            <v-list-item-title>
                            </v-list-item-title>
                            <v-list-item-subtitle>
                                AcceptNo :  {{item.acceptNo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Status :  {{item.status }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CustomerId :  {{item.customerId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CustomerName :  {{item.customerName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                TranType :  {{item.tranType }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CounterPartyId :  {{item.counterPartyId }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                CounterPartyName :  {{item.counterPartyName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                GoodsName :  {{item.goodsName }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Price :  {{item.price }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Qty :  {{item.qty }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ImportCountry :  {{item.importCountry }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                ExportCountry :  {{item.exportCountry }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                BranchNo :  {{item.branchNo }}
                            </v-list-item-subtitle>
                            <v-list-item-subtitle>
                                Message :  {{item.message }}
                            </v-list-item-subtitle>
                        </v-list-item-content>

                        <v-list-item-action>
                            <v-checkbox :input-value="active" color="primary-darker-1"></v-checkbox>
                        </v-list-item-action>
                    </template>
                </v-list-item>
            </v-list-item-group>
        </v-list>
    </div>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'HostAccountPicker',
        props: {
            value: [String, Object, Array, Number, Boolean],
        },
        data: () => ({
            list: [],
            selected: null,
        }),
        async created() {
            var me = this;
            var temp = await axios.get(axios.fixUrl('/accounts'))
            if(temp.data) {
                me.list = temp.data._embedded.accounts;
            }

            if(me.value && typeof me.value == "object" && Object.values(me.value)[0]) {
                var id = Object.values(me.value)[0];
                var tmpValue = await axios.get(axios.fixUrl('/accounts/' + id))
                if(tmpValue.data) {
                    var val = tmpValue.data
                    me.list.forEach(function(item, idx) {
                        if(item.name == val.name) {
                            me.selected = idx
                        }
                    })
                }
            }
        },
        methods: {
            select(val) {
                var obj = {}
                if(val != undefined) {
                    var arr = this.list[val]._links.self.href.split('/');
                    obj['id'] = arr[4]; 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    this.$emit('selected', obj);
                }
            },
        },
    };
</script>

