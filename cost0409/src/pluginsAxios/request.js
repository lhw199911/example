import request from '@/plugins/axios';

export function list_Users(pageFrom, pageNum, likeVal){
    return request.axios({
        url: '/costUser/list',
        method: 'get',
        params: {
            pageFrom,
            pageNum,
            likeVal
        }
    })
}

export function add_User(costUser){
    return request.axios({
        url: '/costUser/add',
        method: 'post',
        data: costUser
    })
}
