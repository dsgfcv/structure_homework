const selections = document.querySelector('.type').children
const descObjs = document.querySelector('.desc').children

for (let i = 0; i < selections.length; i++) {
    selections[i].setAttribute('index', i)
    selections[i].addEventListener('click', function () {
        for (let k = 0; k < selections.length; k++) {
            selections[k].removeAttribute('class')
        }
        this.className = 'current'
        const idx = this.getAttribute('index')
        for (let k = 0; k < descObjs.length; k++) {
            descObjs[k].removeAttribute('class')
        }
        descObjs[idx].className = 'current'
    })
}

handleFileChange = (e) => {
    const files = e.files
    let uploadList = []
    if (files[0].size > 1024 * 1024 * 1) {
        alert('单个文件大小不能超过1M')
        return false
    }
    const formData = new FormData()
    formData.append('file', files[0])
    axios.post('/process', formData).then(res => {
        const { code, message, data } = res.data
        console.log(res)
        if (code === "200") {
            const content = document.querySelector('#content')
            content.style.display = 'block'
            content.innerText = data
        } else {
            alert(message)
        }
    })
}
