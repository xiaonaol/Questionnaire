onload = () => {
  $('#headerDivB').text('项目详情')

  let projectId = $util.getPageParam('seeProject')
  $('#projectName').text(projectId.projectName)
  $('#createTime').text(projectId.creationDate)
  $('#personInCharge').text(projectId.createdBy)
  $('#projectDescribe').text(projectId.projectContent)
  console.log(projectId, 'projectId')

  fetchProjectInfo(projectId)
}

const fetchProjectInfo = (id) => {
  let params = {
    id
  }
  $.ajax({
    url: API_BASE_URL + '/admin/queryProjectList',
    type: "POST",
    data: JSON.stringify(params),
    dataType: "json",
    contentType: "application/json",
    success(res) {
      let info;
      for (let item in res.data) {
        if ($util.getPageParam('seeProject') === res.data[item].id) {
          info = res.data[item]
        }
      }
      $('#projectName').text(info.projectName)
      $('#createTime').text(info.creationDate)
      $('#personInCharge').text(info.createdBy)
      $('#projectDescription').text(info.projectContent)
    }
  })
}