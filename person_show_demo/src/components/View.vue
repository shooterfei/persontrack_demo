<script setup lang="ts">
import { onMounted, ref } from 'vue'
import personImg from '../assets/person.png'
import { Point } from "../interfaces"

defineProps<{ msg: string }>()
const view_draw = ref<HTMLCanvasElement | null>(null)
const img = new Image()
img.src = personImg

let minPoint = { x: 0, y: 0 }
let maxPoint = { x: 800, y: 600 }


// 人员轨迹跟踪
const track = (dom: HTMLCanvasElement | null) => {
  if (dom) {
    cleanCanvas(dom)
    drawCanvas(dom)
    setTimeout(() => {
      track(dom)
    }, 1000 / personsData.fps)
  }
}

// 清空画布
const cleanCanvas = (dom: HTMLCanvasElement | null) => {
  if (dom) {
    let ctx = dom.getContext('2d')
    ctx?.clearRect(0, 0, dom.width, dom.height)
  }
}

// 绘制画布
const drawCanvas = (dom: HTMLCanvasElement | null) => {
  if (dom) {
    let ctx = dom.getContext('2d')
    personsData.data.forEach(item => {
      if (item.queue.length < 2) {
        item.queue = generateData(minPoint, maxPoint, 10, 2, item.queue[0])
      }
      ctx?.drawImage(img, item.queue[0].x, item.queue[0].y, 50, 50)
      item.queue = item.queue.slice(1, item.queue.length)
    })
  }
}

const randomOffset = (x: number, min: number, max: number): number => {
  let maxOffset = 30
  let res
  if (Math.random() < 0.5) {
    res = x + Math.floor(Math.random() * (maxOffset + 1))
  } else {
    res = x - Math.floor(Math.random() * (maxOffset + 1))
  }
  if (res < min || res > max) {
    return randomOffset(x, min, max)
  }
  return res
}

const generateData = (min: Point, max: Point, fps: number, totalTime: number, basePoint?: Point): Point[] => {
  let count = 0
  let res: Point[] = []
  let baseX, baseY
  if (basePoint) {
    baseX = basePoint.x
    baseY = basePoint.y
  } else {
    baseX = Math.floor(Math.random() * (max.x - min.x + 1) + min.x)
    baseY = Math.floor(Math.random() * (max.y - min.y + 1) + min.y)
    basePoint = {
      x: baseX,
      y: baseY
    }
    res.push(basePoint)
  }
  while (count < fps * totalTime) {
    let temp: { x: number; y: number } = {
      x: randomOffset(baseX, min.x, max.x),
      y: randomOffset(baseY, min.y, max.y)
    }
    baseX = temp.x
    baseY = temp.y
    res.push(temp)
    count++
  }
  return res
}

let personsData = {
  fps: 10,
  totalTime: 2,
  data: [
    {
      id: 'person_1',
      queue: generateData(minPoint, maxPoint, 10, 2)
    },
    {
      id: 'person_2',
      queue: generateData(minPoint, maxPoint, 10, 2)
    }
  ]
}


onMounted(() => {
  let dom = view_draw.value
  if (dom) {
    dom.width = dom.clientWidth
    dom.height = dom.clientHeight
    img.onload = () => {
      track(dom)
    }
  }


  let client = new WebSocket("ws://192.168.2.91:8280/chat/test/test")
  client.onopen = (e: Event) => {
    console.log("connect success!")
    client.send("hello")
  }

  client.onmessage = (event: MessageEvent) => {
    console.log(`received Data: ${event.data}`)
  }

  client.onclose = (event: CloseEvent) => {
    if (event.wasClean) {
      console.log(`connect closed cleanly, code=${event.code}, reason=${event.reason}`)
    } else {
      console.log('[close] Connection died')
    }
  }

  client.onerror = (event: Event) => {
    console.log(event.type)
  }
})


</script>

<template>
  <div class="view_base">
    <canvas ref="view_draw" id="view_draw"></canvas>
  </div>
</template>

<style scoped>
.view_base {
  /*  width: 100%;
    height: 100%;*/
  color: #42b983;
  background-image: url("../assets/base.png");
  background-size: 100% 100%;
}

#view_draw {
  width: 100%;
  height: 100%;
}
</style>
