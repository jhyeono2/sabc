<template>
    <v-card outlined>
        <v-card-title>
            Review # {{item._links.self.href.split("/")[item._links.self.href.split("/").length - 1]}}
        </v-card-title>

        <v-card-text>
            <div>
                <String label="AcceptNo" v-model="item.acceptNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerId" v-model="item.customerId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CustomerName" v-model="item.customerName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="TranType" v-model="item.tranType" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="DocumentImg" v-model="item.documentImg" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CounterPartyId" v-model="item.counterPartyId" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="CounterPartyName" v-model="item.counterPartyName" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="GoodsName" v-model="item.goodsName" :editMode="editMode" @change="change" />
            </div>
            <BigDecimal offline label="Price" v-model="item.price" :editMode="false" :key="false" @change="change" />
            <div>
                <Number label="Qty" v-model="item.qty" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Date label="TradeDate" v-model="item.tradeDate" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ImportCountry" v-model="item.importCountry" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="ExportCountry" v-model="item.exportCountry" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="BranchNo" v-model="item.branchNo" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Status" v-model="item.status" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Message" v-model="item.message" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>

        <v-card-actions>
            <v-btn text color="deep-purple lighten-2" large @click="goList">List</v-btn>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="edit"
                    v-if="!editMode"
            >
                Edit
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="save"
                    v-else
            >
                Save
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="remove"
                    v-if="!editMode"
            >
                Delete
            </v-btn>
            <v-btn
                    color="primary"
                    text
                    @click="editMode = false"
                    v-if="editMode"
            >
                Cancel
            </v-btn>
        </v-card-actions>
    </v-card>
</template>


<script>
    const axios = require('axios').default;

    export default {
        name: 'CenterReviewDetail',
        components:{},
        props: {
        },
        data: () => ({
            item: null,
            editMode: false,
        }),
        async created() {
            var me = this;
            var params = this.$route.params;
            var temp = await axios.get(axios.fixUrl('/reviews/' + params.id))
            if(temp.data) {
                me.item = temp.data
            }
        },
        methods: {
            goList() {
                var path = window.location.href.slice(window.location.href.indexOf("/#/"), window.location.href.lastIndexOf("/#"));
                path = path.replace("/#/", "/");
                this.$router.push(path);
            },
            edit() {
                this.editMode = true;
            },
            async remove(){
                try {
                    if (!this.offline) {
                        await axios.delete(axios.fixUrl(this.item._links.self.href))
                    }

                    this.editMode = false;

                    this.$emit('input', this.item);
                    this.$emit('delete', this.item);

                } catch(e) {
                    console.log(e)
                }
            },
        },
    };
</script>
