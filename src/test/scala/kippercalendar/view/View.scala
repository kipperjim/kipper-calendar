package kippercalendar.view

object View {
  def apply() =
    <head>
      <title>Kipper Calendar</title>
    </head> ++
    <div class="lift:surround?with=kippercalendar;at=content">
      <div class={"lift:Snippet"}/>
    </div>
}
